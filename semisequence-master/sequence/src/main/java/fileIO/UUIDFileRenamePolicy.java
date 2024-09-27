package fileIO;

import java.io.File;
import java.util.UUID;

import com.oreilly.servlet.multipart.FileRenamePolicy;


public class UUIDFileRenamePolicy implements FileRenamePolicy {
	
	public File rename(File file) {
		
		String fileName = file.getName();
		int dot = fileName.lastIndexOf(".");
		String body = fileName.substring(0, dot);
		String ext = fileName.substring(dot);
		
		/* 27a76a62-e64b-49b2-b7c4-50fc6312d521 이런 식으로 나오는데, - 문자를 없애고 싶은 경우 replace를 이용할 수 있다. */
		String fileId = UUID.randomUUID().toString().replace("-", "");
		
		System.out.println("기존 파일 명 : " + fileName);
		System.out.println("body : " + body);
		System.out.println("ext : " + ext);
		System.out.println("변경할 파일명 : " + fileId);
		
		/* getParent() : 상위 디렉토리의 경로를 반환한다. */
		return new File(file.getParent(), fileId + ext);

		
	}

}
