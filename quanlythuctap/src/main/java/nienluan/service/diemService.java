package nienluan.service;

import java.util.List;

import nienluan.model.diem;

public interface diemService {
	public void saveDiem(diem d);
	public diem getDiem(String maSoSV,String namHoc,String hocKy,String hocPhan);
	public List<diem> getAllByPk(String namHoc,String hocKy,String hocPhan);
}
