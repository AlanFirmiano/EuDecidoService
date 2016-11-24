package com.br.eudecido.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.eudecido.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	/*@Query("select u from Usuario u where u.id_usuario = :id")
	Usuario findById(@Param("id") Integer id);
	*/
	
	Usuario findById(Integer id);
	
	List<Usuario> findByCpf(String cpf);
	
	Usuario findByEmail(String email);
	
	List<Usuario> findByEmailAndSenha(String email, String senha);

}
