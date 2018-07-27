package htht.system.ocean.model;

import java.util.List;

public class ExcelCoordinate {

    /**
     * type : FeatureCollection
     * features : [{"type":"Feature","id":0,"properties":{"name":"GD051"},"geometry":{"type":"Point","coordinates":[-80.19206680584551,28.31524008350731]}}]
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
         * type : Feature
         * id : 0
         * properties : {"name":"GD051"}
         * geometry : {"type":"Point","coordinates":[-80.19206680584551,28.31524008350731]}
         */

        private String type;
        private int id;
        private PropertiesBean properties;
        private GeometryBean geometry;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public PropertiesBean getProperties() {
            return properties;
        }

        public void setProperties(PropertiesBean properties) {
            this.properties = properties;
        }

        public GeometryBean getGeometry() {
            return geometry;
        }

        public void setGeometry(GeometryBean geometry) {
            this.geometry = geometry;
        }

        public static class PropertiesBean {
            /**
             * name : GD051
             */

            private String name;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class GeometryBean {
            /**
             * type : Point
             * coordinates : [-80.19206680584551,28.31524008350731]
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
    }
}
