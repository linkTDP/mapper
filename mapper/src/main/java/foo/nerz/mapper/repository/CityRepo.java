package foo.nerz.mapper.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.data.repository.PagingAndSortingRepository;

import foo.nerz.mapper.entity.City;



public interface CityRepo  extends PagingAndSortingRepository< City, String >  {
	//bisogna passargli "^"+city
	Page< City > findByNameRegex(String city, Pageable pageable);
}
