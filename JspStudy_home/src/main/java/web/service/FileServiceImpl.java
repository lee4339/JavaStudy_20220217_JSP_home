package web.service;

import java.util.ArrayList;

import repository.FileDao;

public class FileServiceImpl implements FileService{
	private FileDao fileDao;
	
	public FileServiceImpl(FileDao fileDao) {
		this.fileDao = fileDao;
	}
	
	@Override
	public boolean uploadFile(ArrayList<String> fileList) {
		
		return fileDao.uploadFile(fileList) > 0;
	}
	
}
