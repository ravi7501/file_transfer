package neft.file.management.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import neft.file.management.entity.data_table;


@Repository
public interface neft_repository extends CrudRepository<data_table, Double>{

	@Query(value="select UTR_NO, MSG_TYPE, INIT_DATE, AMOUNT, PREV_STATUSES, STATUS, LAST_MOD_TIME,REJECT_REASON, REMIT_INFO from nris_neft",nativeQuery=true)
	public List <data_table> findAll();
}
