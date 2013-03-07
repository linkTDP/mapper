package foo.nerz.mapper.repository;




import org.springframework.data.repository.PagingAndSortingRepository;



import foo.nerz.mapper.entity.Country;

public interface CountryRepo extends PagingAndSortingRepository< Country, String >  {

	

}
