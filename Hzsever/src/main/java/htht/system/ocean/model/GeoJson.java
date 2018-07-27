package htht.system.ocean.model;

import java.util.List;

public class GeoJson {

    /**
     * type : FeatureCollection
     * name : 鐣岀嚎
     * features : [{"type":"Feature","id":0,"properties":{"名称":"惠州市与深圳市海域行政区域界线"},"geometry":{"type":"LineString","coordinates":[[114.50625,22.666819444444446],[114.513625,22.661527777777778],[114.53723611111111,22.664583333333333],[114.55668055555556,22.66986111111111],[114.573625,22.671805555555558],[114.58947222222221,22.66347222222222],[114.59697222222222,22.655694444444443],[114.60113888888888,22.64625],[114.60391666666666,22.624583333333334],[114.60586111111111,22.579305555555557],[114.61808333333333,22.555694444444445],[114.64030555555556,22.536527777777778],[114.64447222222223,22.525972222222222],[114.6436388888889,22.511805555555554],[114.63447222222223,22.49763888888889],[114.60113888888888,22.481805555555553],[114.57725,22.46263888888889],[114.55419444444445,22.42625],[114.54947222222222,22.414861111111108]]}},{"type":"Feature","id":1,"properties":{"名称":"惠东县与海丰县海域行政区域界线"},"geometry":{"type":"LineString","coordinates":[[115.0195138888889,22.70595833333333],[115.01969444444444,22.69338888888889],[115.03558333333334,22.673472222222223],[115.03947222222222,22.659027777777776],[115.09891666666667,22.47486111111111],[115.14394444444446,22.324541666666665]]}}]
     */

    private String type;
    private String name;
    private List<FeaturesBean> features;

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
         * properties : {"名称":"惠州市与深圳市海域行政区域界线"}
         * geometry : {"type":"LineString","coordinates":[[114.50625,22.666819444444446],[114.513625,22.661527777777778],[114.53723611111111,22.664583333333333],[114.55668055555556,22.66986111111111],[114.573625,22.671805555555558],[114.58947222222221,22.66347222222222],[114.59697222222222,22.655694444444443],[114.60113888888888,22.64625],[114.60391666666666,22.624583333333334],[114.60586111111111,22.579305555555557],[114.61808333333333,22.555694444444445],[114.64030555555556,22.536527777777778],[114.64447222222223,22.525972222222222],[114.6436388888889,22.511805555555554],[114.63447222222223,22.49763888888889],[114.60113888888888,22.481805555555553],[114.57725,22.46263888888889],[114.55419444444445,22.42625],[114.54947222222222,22.414861111111108]]}
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
             * 名称 : 惠州市与深圳市海域行政区域界线
             */

            private String 名称;

            public String get名称() {
                return 名称;
            }

            public void set名称(String 名称) {
                this.名称 = 名称;
            }
        }

        public static class GeometryBean {
            /**
             * type : LineString
             * coordinates : [[114.50625,22.666819444444446],[114.513625,22.661527777777778],[114.53723611111111,22.664583333333333],[114.55668055555556,22.66986111111111],[114.573625,22.671805555555558],[114.58947222222221,22.66347222222222],[114.59697222222222,22.655694444444443],[114.60113888888888,22.64625],[114.60391666666666,22.624583333333334],[114.60586111111111,22.579305555555557],[114.61808333333333,22.555694444444445],[114.64030555555556,22.536527777777778],[114.64447222222223,22.525972222222222],[114.6436388888889,22.511805555555554],[114.63447222222223,22.49763888888889],[114.60113888888888,22.481805555555553],[114.57725,22.46263888888889],[114.55419444444445,22.42625],[114.54947222222222,22.414861111111108]]
             */

            private String type;
            private List<List<Double>> coordinates;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public List<List<Double>> getCoordinates() {
                return coordinates;
            }

            public void setCoordinates(List<List<Double>> coordinates) {
                this.coordinates = coordinates;
            }
        }
    }
}
