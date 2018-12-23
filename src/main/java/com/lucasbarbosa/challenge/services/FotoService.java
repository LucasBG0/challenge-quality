package com.lucasbarbosa.challenge.services;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lucasbarbosa.challenge.domain.Foto;
import com.lucasbarbosa.challenge.repositories.FotoRepository;
import com.lucasbarbosa.challenge.services.exceptions.ObjectNotFoundException;

@Service
public class FotoService {
	
	@Autowired
	private FotoRepository repo;
	
	@Autowired
	private S3Service s3Service;
	
	public Foto find(Integer id) {
		Foto obj = repo.findOne(id);
		if (obj==null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Foto.class.getName());
		}
		return obj;
	}
	
	public Foto insert(Foto obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		repo.delete(id);
	}
	
	public List<Foto> findAll(){
		return repo.findAll();
	}
	
	public Page<Foto> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pagerequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pagerequest);
	}
	
	public URI uploadPicture(MultipartFile multipartFile) {
		URI uri = s3Service.uploadFile(multipartFile);
		
		Foto fot = repo.findOne((int) repo.count());
		fot.setImageUrl(uri.toString());
		repo.save(fot);
		
		return uri;
	}
}
