package htht.system.ocean.model;

public class Config {


    /**
     * file : qwer.jpg
     * extent : {"xmax":1.2759128351418851E7,"xmin":1.2739575959081242E7,"ymax":2576555.640332572,"ymin":2567803.5469767842}
     */

    private String file;
    private ExtentBean extent;

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public ExtentBean getExtent() {
        return extent;
    }

    public void setExtent(ExtentBean extent) {
        this.extent = extent;
    }

    public static class ExtentBean {
        /**
         * xmax : 1.2759128351418851E7
         * xmin : 1.2739575959081242E7
         * ymax : 2576555.640332572
         * ymin : 2567803.5469767842
         */

        private Float xmax;
        private Float xmin;
        private Float ymax;
        private Float ymin;


        public Float getXmax() {
            return xmax;
        }

        public void setXmax(Float xmax) {
            this.xmax = xmax;
        }

        public Float getXmin() {
            return xmin;
        }

        public void setXmin(Float xmin) {
            this.xmin = xmin;
        }

        public Float getYmax() {
            return ymax;
        }

        public void setYmax(Float ymax) {
            this.ymax = ymax;
        }

        public Float getYmin() {
            return ymin;
        }

        public void setYmin(Float ymin) {
            this.ymin = ymin;
        }
    }
}
