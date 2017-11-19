package ctci.prac.random;

import java.util.ArrayList;
import java.util.List;

abstract class Entry {
	private String name;
	private long lastAccessedTime;
	private long lastModifiedTime;
	private long createTime;
	private Directory parent;

	public Entry(String name, Directory parent) {
		this.name = name;
		this.parent = parent;
		this.createTime = System.currentTimeMillis();
		lastAccessedTime = System.currentTimeMillis();
		lastModifiedTime = System.currentTimeMillis();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getLastAccessedTime() {
		return lastAccessedTime;
	}

	public void setLastAccessedTime(long lastAccessedTime) {
		this.lastAccessedTime = lastAccessedTime;
	}

	public long getLastModifiedTime() {
		return lastModifiedTime;
	}

	public void setLastModifiedTime(long lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void delete() {
		parent.delete(this);
	}

}

class File extends Entry {
	String data;

	public File(String name, Directory parent, String data) {
		super(name, parent);
		this.data = data;
	}

	public int getSize() {
		return data == null ? 0 : data.length();
	}

}

class Directory extends Entry {

	public Directory(String name, Directory parent) {
		super(name, parent);
		// TODO Auto-generated constructor stub
	}

	List<Entry> contents = new ArrayList<>();

	public int getSize() {
		int size = 0;
		for (Entry entry : contents) {
			if (entry instanceof File) {
				size += ((File) entry).getSize();
			} else {
				size += ((Directory) entry).getSize();
			}
		}
		return size;
	}

	public void add(Entry e) {
		contents.add(e);
	}

	public void delete(Entry e) {
		contents.remove(e);
	}

}

public class FileSystemTest {

}
