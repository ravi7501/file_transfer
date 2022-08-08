package neft.file.management.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import neft.file.management.entity.data_table;


@Repository
public interface neft_repository extends JpaRepository<data_table, Double>{

	@Query(value="select UTR_NO,INIT_DATE,FLOW,AMOUNT,STATUS,PREV_STATUSES,LAST_MOD_DATE,LAST_MOD_TIME,IFSC_SENDER,IFSC_RECVR from nris_neft",nativeQuery=true)
	public List <data_table> findAll();
	
	@Query(value="select status, count(status) as count from nris_neft where flow = 'O' group by status",nativeQuery=true)
	public List<Map<String, Integer>> getneftout();
	
	@Query(value="select status, count(status) as count from nris_neft where flow = 'I' group by status",nativeQuery=true)
	public List<Map<String,Integer>> getneftIn();
	
	@Query(value="select status, count(status) from nris_neft where flow = 'O' and IFSC_SENDER like %:ifsc% group by status",nativeQuery=true)
	public List<Map<String, Integer>> getbank_neft_out(@Param("ifsc") String ifsc);
}
