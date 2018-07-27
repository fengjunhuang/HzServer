package htht.system.ocean.model;

import java.util.List;

public class BuoyCure {

    private List<DataBeanX> data;

    public List<DataBeanX> getData() {
        return data;
    }

    public void setData(List<DataBeanX> data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * type : surface_salt
         * name :
         * data : [{"id":74845,"hour":12,"time":"2018-07-04T12:00:00","value":"14.89"},{"id":74848,"hour":13,"time":"2018-07-04T13:00:00","value":"13.60"},{"id":74851,"hour":14,"time":"2018-07-04T14:00:00","value":"13.99"},{"id":74854,"hour":15,"time":"2018-07-04T15:00:00","value":"15.09"},{"id":74857,"hour":16,"time":"2018-07-04T16:00:00","value":"13.48"},{"id":74860,"hour":17,"time":"2018-07-04T17:00:00","value":"13.96"},{"id":74863,"hour":18,"time":"2018-07-04T18:00:00","value":"13.74"},{"id":74866,"hour":19,"time":"2018-07-04T19:00:00","value":"14.19"},{"id":74869,"hour":20,"time":"2018-07-04T20:00:00","value":"13.64"},{"id":74872,"hour":21,"time":"2018-07-04T21:00:00","value":"14.89"},{"id":74875,"hour":22,"time":"2018-07-04T22:00:00","value":"14.73"},{"id":74876,"hour":23,"time":"2018-07-04T23:00:00","value":"14.25"},{"id":75221,"hour":0,"time":"2018-07-05T00:00:00","value":"14.36"},{"id":75224,"hour":1,"time":"2018-07-05T01:00:00","value":"14.97"},{"id":75227,"hour":2,"time":"2018-07-05T02:00:00","value":"14.68"},{"id":75230,"hour":3,"time":"2018-07-05T03:00:00","value":"14.12"},{"id":75233,"hour":4,"time":"2018-07-05T04:00:00","value":"14.65"},{"id":75236,"hour":5,"time":"2018-07-05T05:00:00","value":"14.03"},{"id":75238,"hour":6,"time":"2018-07-05T06:00:00","value":"15.18"},{"id":75241,"hour":7,"time":"2018-07-05T07:00:00","value":"14.83"},{"id":75243,"hour":8,"time":"2018-07-05T08:00:00","value":"14.12"},{"id":75246,"hour":9,"time":"2018-07-05T09:00:00","value":"13.54"},{"id":75249,"hour":10,"time":"2018-07-05T10:00:00","value":"13.06"},{"id":75252,"hour":11,"time":"2018-07-05T11:00:00","value":"14.72"}]
         */

        private String type;
        private String name;
        private List<DataBean> data;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * id : 74845
             * hour : 12
             * time : 2018-07-04T12:00:00
             * value : 14.89
             */

            private int id;
            private int hour;
            private String time;
            private String value;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getHour() {
                return hour;
            }

            public void setHour(int hour) {
                this.hour = hour;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }
        }
    }
}
