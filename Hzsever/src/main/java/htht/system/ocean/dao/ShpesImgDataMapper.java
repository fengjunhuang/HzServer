package htht.system.ocean.dao;

import htht.system.ocean.core.Mapper;
import htht.system.ocean.model.ShpesImgData;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ShpesImgDataMapper extends Mapper<ShpesImgData> {
    public int createImg(ShpesImgData shpesImgData);
    @Update("UPDATE  SHPES_IMG_DATA  SET SHP_DESCRIBE = #{shpDescribe} WHERE SHP_CHILD_ID = #{shpChildId} AND BRANCH_ID = #{branchId} ")
    int updateShpDescribe(@Param("shpChildId") Long shpChildId, @Param("shpDescribe") String shpDescribe,@Param("branchId" )Long branchId);
    @Update("UPDATE  SHPES_IMG_DATA  SET IMG_PATH =#{imgPath}  WHERE SHP_CHILD_ID = #{shpChildId} AND BRANCH_ID = #{branchId} ")
    int updateShpImg(@Param("shpChildId") Long shpChildId, @Param("imgPath") String imgPath,@Param("branchId" )Long branchId);


    @Select("SELECT * FROM SHPES_IMG_DATA WHERE BRANCH_ID =#{branchId} AND SHP_CHILD_ID = #{shpChildId}  ")
    @Results(
            {
                    @Result(id = true, column = "IMG_ID", property = "imgId"),
                    @Result(column = "SHP_CHILD_ID", property = "shpChildId"),
                    @Result(column = "IMG_PATH", property = "imgPath"),
                    @Result(column = "BRANCH_ID", property = "branchId"),
                    @Result(column = "SHP_DESCRIBE", property = "shpDescribe"),
            })
    @ResultType(ShpesImgData.class)
    public List<ShpesImgData>  queryShpesChBybranchId(@Param("branchId" )Long branchId, @Param("shpChildId") Long shpChildId);

}