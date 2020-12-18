package iozip.transactions;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class TransactionFileManager {

    public void saveTransactions(Path path, List<Transaction> transactions) {

        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(Files.newOutputStream(path)))){
            String out;
            for (Transaction item: transactions) {
                zipOutputStream.putNextEntry(new ZipEntry(Long.toString(item.getId())));
                out = item.getTime().toString() + "\n";
                //PrintStream outputstream = new PrintStream(zipOutputStream);
                //outputstream.println(item.getTime());
                zipOutputStream.write(out.getBytes(StandardCharsets.UTF_8));
                out = item.getAccount() + "\n";
                zipOutputStream.write(out.getBytes(StandardCharsets.UTF_8));
                out = String.format(Locale.US,"%.1f\n", item.getAmount());
                zipOutputStream.write(out.getBytes(StandardCharsets.UTF_8));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot write file", e);
        }
    }

    public static void main(String[] args) {
        List<Transaction> transactionList = List.of(
                new Transaction(345L, LocalDateTime.of(2018, 2, 21, 12, 5, 31), "10092385-34562856-00008701", 412000.0),
                new Transaction(1297L, LocalDateTime.of(2018, 2, 21, 13, 10, 6), "10092385-23651299-00123013", -12000.0)
        );
        Path path = Path.of("trans.zip");
        TransactionFileManager manager = new TransactionFileManager();

        manager.saveTransactions(path, transactionList);

    }
}
