package com.lucasbarbosa.challenge.services;

import java.awt.image.BufferedImage;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	
	@Autowired
	private ImageService imageService;
	
	@Value("${img.prefix.client.profile}")
	private String prefix;

	@Value("${img.profile.size}")
	private Integer size;
	
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
		
		BufferedImage jpgImage = imageService.getJpgImageFromFile(multipartFile);
		
		BufferedImage jpgImageCrop = imageService.getJpgImageFromFile(multipartFile);
		jpgImageCrop = imageService.cropSquare(jpgImageCrop);
		jpgImageCrop = imageService.resize(jpgImageCrop, size);
		
		String fileName = prefix + (int) repo.count() + ".jpg";
		String fileNameCrop = prefix + (int) repo.count() + "-small.jpg";
		
		s3Service.uploadFile(imageService.getInputStream(jpgImageCrop, "jpg"), fileNameCrop, "image");
		
		return s3Service.uploadFile(imageService.getInputStream(jpgImage, "jpg"), fileName, "image");
	}
}
