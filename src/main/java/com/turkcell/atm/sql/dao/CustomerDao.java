package com.turkcell.atm.sql.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.turkcell.atm.sql.dto.BankDto;
import com.turkcell.atm.sql.dto.CustomerDto;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class CustomerDao implements IDaoConnection<CustomerDto> {
	
	// CREATE
	@Override
	public void create(CustomerDto customerDto) {
		try (Connection connection = getInterfaceConnection()) {
			connection.setAutoCommit(false); // transaction
			String sql = "insert into  customer (customer_name,customer_surname,customer_identity,bank_id) values (?,?,?,?);";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, customerDto.getCustomerName());
			preparedStatement.setString(2, customerDto.getCustomerSurName());
			preparedStatement.setString(3, customerDto.getCustomerIdentity());
			preparedStatement.setLong(4, customerDto.getBankDto().getId());
			
			int rowEffected = preparedStatement.executeUpdate();
			if (rowEffected > 0) {
				log.info(CustomerDto.class + " Ekleme Basarili");
				connection.commit(); // transaction
			} else {
				log.error(CustomerDto.class + " !!!! Ekleme Basarisiz");
				connection.rollback(); // transaction
			}
		} catch (Exception e) {
			log.error(CustomerDto.class + " !!!! Ekleme sirasinda hata meydana geldi");
			e.printStackTrace();
		}
	}
	
	// UPDATE
	@Override
	public void update(CustomerDto customerDto) {
		try (Connection connection = getInterfaceConnection()) {
			connection.setAutoCommit(false); // transaction
			String sql = "update customer set customer_name=?,customer_surname=?,customer_identity=? where customer_id=?;";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, customerDto.getCustomerName());
			preparedStatement.setString(2, customerDto.getCustomerSurName());
			preparedStatement.setString(3, customerDto.getCustomerIdentity());
			preparedStatement.setLong(4, customerDto.getId());
			
			int rowEffected = preparedStatement.executeUpdate();
			if (rowEffected > 0) {
				log.info(CustomerDto.class + " Güncelleme Basarili");
				connection.commit(); // transaction
			} else {
				log.error(CustomerDto.class + " !!!! Güncelleme Basarisiz");
				connection.rollback(); // transaction
			}
		} catch (Exception e) {
			log.error(CustomerDto.class + " !!!! Güncelleme sýrasýnda hata meydana geldi");
			e.printStackTrace();
		}
	}
	
	// DELETE
	@Override
	public void delete(CustomerDto customerDto) {
		try (Connection connection = getInterfaceConnection()) {
			connection.setAutoCommit(false); // transaction
			String sql = "delete from  customer where bank_id=?;";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, customerDto.getId());
			
			int rowEffected = preparedStatement.executeUpdate();
			if (rowEffected > 0) {
				log.info(CustomerDto.class + " Silme Basarili");
				connection.commit(); // transaction
			} else {
				log.error(CustomerDto.class + " !!!! Silme Basarisiz");
				connection.rollback(); // transaction
			}
		} catch (Exception e) {
			log.error(CustomerDto.class + " !!!! Silme sirasinda hata meydana geldi");
			e.printStackTrace();
		}
		
	}
	
	// LIST
	// SELECT
	@Override
	public ArrayList<CustomerDto> list() {
		ArrayList<CustomerDto> list = new ArrayList<CustomerDto>();
		CustomerDto customerDto;
		
		try (Connection connection = getInterfaceConnection()) {
			String sql = "select *  from  customer;";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			// resultSet.getString("branch_name")
			
			while (resultSet.next()) {
				customerDto = new CustomerDto();
				customerDto.setId(resultSet.getLong("customer_id"));
				customerDto.setCustomerName(resultSet.getString("customer_name"));
				customerDto.setCustomerSurName(resultSet.getString("customer_surname"));
				customerDto.setCustomerIdentity(resultSet.getString("customer_identity"));
				customerDto.setBankDto((BankDto) resultSet.getObject("bank_id"));
				customerDto.setCreatedDate(resultSet.getDate("created_date"));
				list.add(customerDto);
			}
		} catch (Exception e) {
			log.error(CustomerDto.class + " !!!! Silme sirasinda hata meydana geldi");
			e.printStackTrace();
		}
		return list;
	}
}
