package dsi.senior.repositories;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dsi.senior.entities.Illnesses;

@Repository
public interface IllnessDao extends CrudRepository<Illnesses, Long> {

	/**********************************Find illness ByLabel***************************/
	@Query("SELECT illness from Illnesses illness WHERE illness.label =:label")
	public Illnesses findIllnessByLabel(@Param("label")String label);
}
