import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.zip.Inflater;

public class Crypt12 {
    public static void main(final String[] args) {
       /* final String c12File         = "1/msgstore.db.crypt12"; // input file
        final String decryptedDbFile = "1/msgstore.db";         // sqlite3 db output file
        final String keyFile         = "1/key";
        try {
            final byte[] key; try(FileInputStream s = new FileInputStream(keyFile)) { key = s.readAllBytes(); }
            final byte[] buf; try(FileInputStream s = new FileInputStream(c12File)) { buf = s.readAllBytes(); }
            if(!Arrays.equals(key, 27, 78, buf, 0, 51)) { System.out.println("Wrong Key-File"); return; }
            final int available = buf.length - 67  - 20; // 67 Byte Header + 20 byte footer
            final Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            final GCMParameterSpec iv = new GCMParameterSpec(128, buf, 51, 16);
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, 126, 32, "AES"), iv);
            final int zipLen = cipher.doFinal(buf, 67, available, buf, 0);
            final Inflater unzip = new Inflater(false);
            try(FileOutputStream s = new FileOutputStream(decryptedDbFile)) {
                unzip.setInput(buf, 0, zipLen);
                final byte[] b = new byte[1024];
                while(!unzip.needsInput()) {
                    final int l = unzip.inflate(b, 0, b.length);
                    if(l > 0) s.write(b, 0, l);
                }
            }
        } catch (final Exception e) {
            e.printStackTrace(System.out);
        }*/
    }
}