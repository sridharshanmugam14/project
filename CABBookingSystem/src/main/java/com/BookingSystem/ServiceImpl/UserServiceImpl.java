package com.BookingSystem.ServiceImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.BookingSystem.Entity.User;
import com.BookingSystem.Repository.UserRepository;
import com.BookingSystem.Service.UserService;

@Service

public class UserServiceImpl implements UserService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> getAllAbstractUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Transactional
	public String insertAbstractUser(User user) {
		User savedUser = userRepository.save(user);
		if (userRepository.findById(savedUser.getId()).isPresent())
			return "sucess";
		else
			return "faild";
	}

	@Transactional
	public ResponseEntity<Object> updateAbractUser(Integer cabId, User user) {

		if (userRepository.findById(cabId).isPresent()) {
			User userObj = userRepository.findById(cabId).get();
			userObj.setUserName(user.getUserName());
			userObj.setPassword(user.getPassword());
			userObj.setAddress(user.getAddress());
			userObj.setMobileNumber(user.getMobileNumber());
			userObj.setEmail(user.getEmail());

			User saveduser = userRepository.save(userObj);
			if (userRepository.findById(saveduser.getId()).isPresent())
				return ResponseEntity.ok().body("Successfully Updated user");
			else
				return ResponseEntity.unprocessableEntity().body("Failed to update the specified user");
		} else
			return ResponseEntity.unprocessableEntity().body("The specified Abstract is not found");
	}

	public List<User> validateLogin(User user) {
		List<User> users = null;
		User userObj = new User();
		try {
			String sql = "SELECT * FROM user WHERE user_name = '" + user.getUserName() + "'";
			RowMapper<User> rowMapper = new RowMapper<User>() {
				@Override
				public User mapRow(ResultSet rs, int rowNum) throws SQLException {
					userObj.setId(rs.getInt(1));
					userObj.setAddress(rs.getString(2));
					userObj.setEmail(rs.getString(3));
					userObj.setMobileNumber(rs.getString(4));
					userObj.setPassword(rs.getString(5));
					userObj.setUserName(rs.getString(6));
					return user;
				}
			};
			// AbstractUser abstractUser = jdbcTemplate.queryForObject(sql, new Object[] {
			// "sri" }, AbstractUser.class);
			users = jdbcTemplate.query(sql, rowMapper);
			System.out.println(">>>>>>>Obj : " + user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

}
