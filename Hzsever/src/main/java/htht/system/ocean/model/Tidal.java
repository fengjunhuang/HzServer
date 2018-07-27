package htht.system.ocean.model;

import java.util.List;

public class Tidal {


    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * zxcw : 515
         * time : 2018-06-23 14:00
         * id : 1
         * name : 澳头综合潮位站
         * lng : 114.543223
         * lat : 22.710287
         */

        private String zxcw;
        private String time;
        private String id;
        private String name;
        private String lng;
        private String lat;

        public String getZxcw() {
            return zxcw;
        }

        public void setZxcw(String zxcw) {
            this.zxcw = zxcw;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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
