package htht.system.ocean.model;

import java.util.List;

public class GeoModelPoint {


    /**
     * features : [{"geometry":{"coordinates":[-80.19206680584551,28.31524008350731],"type":"Point"},"id":0,"type":"Feature","properties":{"name":"GD051","Id":0}}]
     * type : FeatureCollection
     */

    private String type;
    private List<FeaturesBean> features;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<FeaturesBean> getFeatures() {
        return features;
    }

    public void setFeatures(List<FeaturesBean> features) {
        this.features = features;
    }

    public static class FeaturesBean {
        /**
         * geometry : {"coordinates":[-80.19206680584551,28.31524008350731],"type":"Point"}
         * id : 0
         * type : Feature
         * properties : {"name":"GD051","Id":0}
         */

        private GeometryBean geometry;
        private int id;
        private String type;
        private PropertiesBean properties;

        public GeometryBean getGeometry() {
            return geometry;
        }

        public void setGeometry(GeometryBean geometry) {
            this.geometry = geometry;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public PropertiesBean getProperties() {
            return properties;
        }

        public void setProperties(PropertiesBean properties) {
            this.properties = properties;
        }

        public static class GeometryBean {
            /**
             * coordinates : [-80.19206680584551,28.31524008350731]
             * type : Point
             */

            private String type;
            private List<Double> coordinates;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public List<Double> getCoordinates() {
                return coordinates;
            }

            public void setCoordinates(List<Double> coordinates) {
                this.coordinates = coordinates;
            }
        }

        public static class PropertiesBean {
            /**
             * name : GD051
             * Id : 0
             */

            private String name;
            private int Id;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getId() {
                return Id;
            }

            public void setId(int Id) {
                this.Id = Id;
            }
        }
    }
}
