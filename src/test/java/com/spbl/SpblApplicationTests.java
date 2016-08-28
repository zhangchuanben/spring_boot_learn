package com.spbl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.spbl.domain.Book;
import com.spbl.repository.BookRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
public class SpblApplicationTests {
	@Autowired
	private WebApplicationContext context;
	@Autowired
	private BookRepository repository;
	@Value("${local.server.port}")
	private int port;
	
	private MockMvc mockMvc;
	private TestRestTemplate restTemplate = new TestRestTemplate();
	@Before
	public void setupMockMvc() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	
	@Rollback // 支持事务回滚
	@Test
	public void contextLoads() {
		//repository.findAll().forEach(repository::delete);
		/*Book book = new Book();
		book.setDescription("哈利波特");
		book.setIsbn("abcd");
		book.setTitle("哈利波特全集");
		repository.save(book);*/
		
		
		assertEquals(1, repository.count());
	}
	
	
	// 请求测试
	@Test
	public void webappBookIsbnApi() {
		Book book = restTemplate.getForObject("http://localhost:"+port+
				"/books/abcd", Book.class);
		assertNotNull(book);
		assertEquals("哈利波特全集", book.getTitle());
	}

}
