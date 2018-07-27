package htht.system.ocean.service.impl;
  
import java.util.List;  
  
import com.mongodb.DBObject;  
  
/** 
 * mongodb 父接口类 
 * @author babylon 
 * @version 1.1 
 * @date 2016年7月12日-下午1:22:23 
 */  
public interface  MongoDao {  
      
    public DBObject findOne(String collection, DBObject query, DBObject fields);  
       
    public List<DBObject> find(String collection, DBObject query, DBObject fields, DBObject orderBy, int pageNum, int pageSize);  
   
    public List<DBObject> find(String collection, DBObject query, DBObject fields, DBObject orderBy, int limit);  
   
    public void delete(String collection, DBObject dbObject);  
   
    public void save(String collection, DBObject dbObject);  
   
    public void update(String collection, DBObject query, DBObject update, boolean upsert, boolean multi);  
   
    public Long count(String collection, DBObject query);  
   
    public List<?> distinct(String collection, String key, DBObject query);  
   
}  