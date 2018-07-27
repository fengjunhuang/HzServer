//package htht.system.ocean.service;
//
//import htht.system.ocean.model.Branch;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.annotation.CachePut;
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Service;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Service
//public class RedisService {
//
//    @Autowired
//    private RedisTemplate<String, Object> redisTemplate;
//
//    private Set<Branch> Branchs = new HashSet<Branch>();
//
//
//
//    @CachePut(value = "Branch", key = "'Branch:'+#Branch.id")
//    public Branch addBranch(Branch Branch) {
//        Branchs.add(Branch);
//        return Branch;
//    }
//
//    @Cacheable(value = "Branch", key = "'Branch:'+#id")
//    public Branch addBranch(String id, String name, int age) {
//        Branch Branch = new Branch();
//        Branchs.add(Branch);
//        return Branch;
//    }
//
//
//}