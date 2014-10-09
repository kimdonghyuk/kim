package org.han.mp32.vo;

public class MP3 {

	private final String fileName;
	private final String desc;
	// final : ������ ���� �ϳ� setting�Ǹ� �ٲ� �� ���� 
	// fileName�� �ѹ� �����Ǹ� �ܺο��� �Ժη� �ٲ� �� ���� �ϱ� ���ؼ� final�� ��������
	public MP3(String fileName, String desc) {
		super();
		this.fileName = fileName;
		this.desc = desc;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public String getDesc() {
		return desc;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((desc == null) ? 0 : desc.hashCode());
		result = prime * result
				+ ((fileName == null) ? 0 : fileName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MP3 other = (MP3) obj;
		if (desc == null) {
			if (other.desc != null)
				return false;
		} else if (!desc.equals(other.desc))
			return false;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MP3 [fileName=" + fileName + ", desc=" + desc + "]";
	}
	
	
}