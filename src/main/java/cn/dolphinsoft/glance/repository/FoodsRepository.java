package cn.dolphinsoft.glance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import cn.dolphinsoft.glance.entity.FoodsEntity;

public interface FoodsRepository extends JpaRepository<FoodsEntity, Integer> {

	@Modifying
	@Query(value = "DELETE FROM foods WHERE foodid = ?1 ", nativeQuery = true)
	void deleteById(Integer id);

}
