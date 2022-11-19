/**
 * 
 */
package com.example.passwordvalidation.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author vinod
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable{

	private static final long serialVersionUID = -2266153632544101546L;
	
	private String userName;
	private String password;

}
