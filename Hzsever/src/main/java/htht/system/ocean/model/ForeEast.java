package htht.system.ocean.model;

import java.util.List;

public class ForeEast {

    /**
     * data : {"stations":{"id":"3","code":"HZ003","red_alert":200,"blue_alert":160,"tide_alter":200,"crest_height":4.7,"name":"巽寮赤砂综合潮位站","lng":"114.946114","lat":"22.720547"},"data":[]}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * stations : {"id":"3","code":"HZ003","red_alert":200,"blue_alert":160,"tide_alter":200,"crest_height":4.7,"name":"巽寮赤砂综合潮位站","lng":"114.946114","lat":"22.720547"}
         * data : []
         */

        private StationsBean stations;
        private List<?> data;

        public StationsBean getStations() {
            return stations;
        }

        public void setStations(StationsBean stations) {
            this.stations = stations;
        }

        public List<?> getData() {
            return data;
        }

        public void setData(List<?> data) {
            this.data = data;
        }

        public static class StationsBean {
            /**
             * id : 3
             * code : HZ003
             * red_alert : 200
             * blue_alert : 160
             * tide_alter : 200
             * crest_height : 4.7
             * name : 巽寮赤砂综合潮位站
             * lng : 114.946114
             * lat : 22.720547
             */

            private String id;
            private String code;
            private int red_alert;
            private int blue_alert;
            private int tide_alter;
            private double crest_height;
            private String name;
            private String lng;
            private String lat;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public int getRed_alert() {
                return red_alert;
            }

            public void setRed_alert(int red_alert) {
                this.red_alert = red_alert;
            }

            public int getBlue_alert() {
                return blue_alert;
            }

            public void setBlue_alert(int blue_alert) {
                this.blue_alert = blue_alert;
            }

            public int getTide_alter() {
                return tide_alter;
            }

            public void setTide_alter(int tide_alter) {
                this.tide_alter = tide_alter;
            }

            public double getCrest_height() {
                return crest_height;
            }

            public void setCrest_height(double crest_height) {
                this.crest_height = crest_height;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getLng() {
                return lng;
            }

            public void setLng(String lng) {
                this.lng = lng;
            }

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }
        }
    }
}
