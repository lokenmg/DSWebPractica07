/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package org.uv.DSWeb_Practica07;

import org.springframework.data.jpa.repository.JpaRepository;


public interface RepositoryUser extends JpaRepository<User, Long> {
    
}
