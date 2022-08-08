package neft.file.management.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import neft.file.management.entity.rtgsTable;


@Repository
public interface rtgs_repository extends JpaRepository<rtgsTable, Double>{
	@Query(value="select UTR_NO,INIT_DATE,FLOW,AMOUNT,STATUS,PREV_STATUSES,LAST_MOD_DATE,LAST_MOD_TIME,IFSC_SENDER,IFSC_RECVR from nris_rtgs",nativeQuery=true)
	public List <rtgsTable> findAll();
	
	@Query(value="select status, count(status) as count from nris_rtgs where flow = 'O' group by status",nativeQuery=true)
	public List<Map<String, Integer>> getrtgsout();

	@Query(value="select status, count(status) as count from nris_rtgs where flow = 'I' group by status",nativeQuery=true)
	public List<Map<String, Integer>> getrtgsIn();

}
