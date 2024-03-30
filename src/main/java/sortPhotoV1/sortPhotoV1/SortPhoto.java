package sortPhotoV1.sortPhotoV1;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifSubIFDDirectory;
/**
 * Hello world!
 *
 */
public class SortPhoto 
{
	public static String newdir, oldir;
    public static void main( String[] args )
    {
    	
    	oldir = args[0];
		newdir = args[1];
		try {
			leerdir(oldir);
		} catch (ImageProcessingException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
        

    }
	private static void leerdir(String path) throws IOException, ImageProcessingException {
		File file = new File(path);
		File[] files;
		if (file.isDirectory()) {
			files = file.listFiles();
			for (File nfile : files) {
				leerdir(nfile.getCanonicalPath());
			}

		}
		if (file.isFile()) {

			Pattern patron = Pattern.compile("IMG.*jpg");

			Matcher m = patron.matcher(file.getCanonicalPath());
			if (m.find()) {
			
				Date date = leermetadatos(file);
			

				String ndir = creardirectorio(date);
				moverarchivo(file, ndir);

			}

		}

	}

	private static void moverarchivo(File file, String ndir) {
		File comprobar=new File(ndir + "/" + file.getName());
		if(!comprobar.exists()){
			file.renameTo(comprobar);

		}
	}

	private static String creardirectorio(Date date) {
		
		
		Map<String,String> fechas = new HashMap<String,String>();
		fechas.put("01", "Enero");
		fechas.put("02", "Febrero");
		fechas.put("03", "Marzo");
		fechas.put("04", "Abril");
		fechas.put("05", "Mayo");
		fechas.put("06", "Junio");
		fechas.put("07", "Julio");
		fechas.put("08", "Agosto");
		fechas.put("09", "Septiembre");
		fechas.put("10", "Octubre");
		fechas.put("11", "Noviembre");
		fechas.put("12", "Diciembre");
		String mes, anyo;

		SimpleDateFormat formatterMM = new SimpleDateFormat("MM");
		SimpleDateFormat formatteryyyy = new SimpleDateFormat("yyyy");

		mes = formatterMM.format(date);
		mes= fechas.get(mes);
		anyo = formatteryyyy.format(date);
		File nuevodir = new File(newdir + "/" + anyo + "/" + mes);
		System.out.println(nuevodir.toString());

		if (!nuevodir.exists()) {
			nuevodir.mkdirs();
		}
		return nuevodir.getAbsolutePath();

	}

	public static Date leermetadatos(File file) throws ImageProcessingException, IOException {

		
		
		Date date= new Date();
		File imagePath = new File(file.getAbsolutePath());

			Calendar myCal = Calendar.getInstance();
			String regex = "^IMG.*";
			Pattern patron = Pattern.compile(regex);
			Matcher m = patron.matcher(file.getName());
			
			if (m.find()) {
				regex = "^IMG_(\\d{4})(\\d{2})(\\d{2})";
				patron = Pattern.compile(regex);
				m = patron.matcher(file.getName());
				
				if (m.find()) {
					String mes, anyo, dia;
					anyo = m.group(1);
					mes = m.group(2);
					dia = m.group(3);
					

					myCal.set(Calendar.YEAR, Integer.parseInt(anyo));
					myCal.set(Calendar.MONTH, Integer.parseInt(mes));
					myCal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dia));
					date = myCal.getTime();

				}
			} else {
				myCal.set(Calendar.YEAR, 2000);
				myCal.set(Calendar.MONTH, 01);
				myCal.set(Calendar.DAY_OF_MONTH, 01);
				date = myCal.getTime();
			}


		System.out.println(date);

		return date;
	}
}
