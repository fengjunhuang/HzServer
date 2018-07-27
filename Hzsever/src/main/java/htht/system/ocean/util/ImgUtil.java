package htht.system.ocean.util;

import com.alibaba.fastjson.JSON;
import htht.system.ocean.configurer.Constant;
import htht.system.ocean.model.Config;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ColorModel;
import java.awt.image.ImageObserver;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class ImgUtil {

    private static String json="{\"file\": \"qwer.jpg\",\"extent\": {\"xmax\": 12759128.351418851,\"xmin\": 12739575.959081242,\"ymax\": 2576555.640332572,\"ymin\": 2567803.5469767842 }}";

    public static byte[] createImg(Float xmax, Float ymax, Float xmin, Float ymin, Float w , Float h, Config config) throws IOException {

        Float xRatio = w / (xmax -xmin);
        Float yRatio = h / (ymax - ymin);

        //计算绘制区Extent的对角坐标
        Float leftTopX = xRatio * (config.getExtent().getXmin() - xmin);
        Float leftTopY = yRatio * (ymax - config.getExtent().getYmax());
        Float BottomRightX = xRatio * (config.getExtent().getXmax() - xmin);
        Float BottomRightY = yRatio * (ymax - config.getExtent().getYmin());

        Float wb= BottomRightX - leftTopX;
       Float hb = BottomRightY - leftTopY;

        BufferedImage buffImg = new BufferedImage(w.intValue(), h.intValue(),
                BufferedImage.TYPE_INT_RGB);
        Graphics2D gd = buffImg.createGraphics();
        //设置透明  start
        buffImg = gd.getDeviceConfiguration().createCompatibleImage(w.intValue(), h.intValue(), Transparency.TRANSLUCENT);
//        buffImg = gd.getDeviceConfiguration().createCompatibleImage(w.intValue(), h.intValue(), Transparency.TRANSLUCENT);
//        gd.dispose();
//        gd = buffImg.createGraphics();
        gd=buffImg.createGraphics();
        BufferedImage image = ImageIO.read(new File(Constant.GRAPHICSIMAGE+config.getFile()));

//        ImageIO.write(  buffImg, "png", new File("d:/img/targetPIC/"+"name1"+".png"));
        gd.drawImage(image, leftTopX.intValue(),  leftTopY.intValue(),wb.intValue(),hb.intValue(), null);

        ByteArrayOutputStream  byteArrayOutputStream =new ByteArrayOutputStream();
//       ImageIO.write(buffImg ,"png", new File("d:/img/targetPIC/"+"name"+".png"));

        ImageIO.write(buffImg ,"png", byteArrayOutputStream);
      return   byteArrayOutputStream.toByteArray();


    }

    public static void main(String[] args) {

        try {
            createImg(12918742.20078851f,2750308.1944788327f,12619512.5760356f,2451078.569725922f,2048f,2048f, JSON.parseObject(json,Config.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
