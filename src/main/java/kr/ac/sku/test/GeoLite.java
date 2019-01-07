package kr.ac.sku.test;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

import com.maxmind.geoip.Location;
import com.maxmind.geoip.LookupService;
import com.maxmind.geoip.regionName;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.City;
import com.maxmind.geoip2.record.Country;
import com.maxmind.geoip2.record.Postal;
import com.maxmind.geoip2.record.Subdivision;

public class GeoLite {

	public static void main(String[] args) throws IOException, GeoIp2Exception {
		 /*String ipAddress = "220.67.115.1";
		  File file = new File("C:\\Users\\S401-09\\Desktop\\spring\\GeoLiteCity.dat");
		  
		  LookupService lookup = null;
		  try {
		   lookup = new LookupService(file, LookupService.GEOIP_MEMORY_CACHE);
		  } catch (IOException e) {
		   System.err.println(e.getMessage());
		  }
		  Location ls = lookup.getLocation(ipAddress);
		  
		  System.out.println("국가코드 :"+ls.countryCode);
		  System.out.println("국가명 :"+ls.countryName);
		  System.out.println("지역코드 :"+ls.region);
		  System.out.println("지역명 :"+regionName.regionNameByCode(ls.countryCode, ls.region));
		  System.out.println("도시명 :"+ls.city);
		  System.out.println("우편번호 :"+ls.postalCode);
		  System.out.println("위도 :"+ls.latitude);
		  System.out.println("경도 :"+ls.longitude);*/
		
		// A File object pointing to your GeoIP2 or GeoLite2 database
		File database = new File("C:\\Users\\S401-09\\Desktop\\spring\\GeoLite2-City_20181106\\GeoLite2-City.mmdb");

		// This creates the DatabaseReader object. To improve performance, reuse
		// the object across lookups. The object is thread-safe.
		DatabaseReader reader = new DatabaseReader.Builder(database).build();

		InetAddress ipAddress = InetAddress.getByName("175.223.49.74");

		// Replace "city" with the appropriate method for your database, e.g.,
		// "country".
		CityResponse response = reader.city(ipAddress);

		Country country = response.getCountry();
		System.out.println(country.getIsoCode());            // 'US'
		System.out.println(country.getName());               // 'United States'
		System.out.println(country.getNames().get("zh-CN")); // '美国'

		Subdivision subdivision = response.getMostSpecificSubdivision();
		System.out.println(subdivision.getName());    // 'Minnesota'
		System.out.println(subdivision.getIsoCode()); // 'MN'

		City city = response.getCity();
		System.out.println(city.getName()); // 'Minneapolis'

		Postal postal = response.getPostal();
		System.out.println(postal.getCode()); // '55455'

		com.maxmind.geoip2.record.Location location = response.getLocation();
		System.out.println(location.getLatitude());  // 44.9733
		System.out.println(location.getLongitude()); // -93.2323

	}

}
