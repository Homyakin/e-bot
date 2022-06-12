package ru.homyakin.ebot.utils;

import java.io.InputStream;
import java.util.Optional;
import javax.imageio.ImageIO;
import net.sourceforge.tess4j.ITessAPI;
import net.sourceforge.tess4j.Tesseract;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.homyakin.ebot.config.TesseractConfig;

public class TesseractUtils {
    private static final Logger logger = LoggerFactory.getLogger(TesseractUtils.class);

    public static Optional<String> scanText(InputStream photo) {
        try {
            Tesseract tesseract = new Tesseract();
            tesseract.setDatapath(TesseractConfig.datapath());
            tesseract.setLanguage("rus");
            tesseract.setPageSegMode(ITessAPI.TessPageSegMode.PSM_AUTO_OSD);
            tesseract.setOcrEngineMode(ITessAPI.TessOcrEngineMode.OEM_LSTM_ONLY);
            String result = tesseract.doOCR(ImageIO.read(photo));
            return Optional.of(
                result
                    .trim()
                    .replace("\n", " ")
                    .replaceAll("\\s+", " ")
            );
        } catch (Exception e) {
            logger.error("Unable to parse photo", e);
            return Optional.empty();
        }
    }
}
