package htht.system.ocean.dao;

import htht.system.ocean.core.Mapper;
import htht.system.ocean.model.BranchSubjects;

public interface BranchSubjectsMapper extends Mapper<BranchSubjects> {
    int create(BranchSubjects branchSubjects);

}