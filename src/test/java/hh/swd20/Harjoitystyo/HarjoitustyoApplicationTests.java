package hh.swd20.Harjoitystyo;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.Harjoitystyo.webcontroller.DanceClassController;
import hh.swd20.Harjoitystyo.webcontroller.UserDetailServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
public class HarjoitustyoApplicationTests {
	
	@Autowired
	private DanceClassController danceClassController;
	
	@Autowired
	private UserDetailServiceImpl usercontroller;

	@Test
	public void contextLoads() throws Exception {
		assertThat(danceClassController).isNotNull();
		assertThat(usercontroller).isNotNull();
	}

}
