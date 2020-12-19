package iodatastream.bank;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class BankAccountManager {

    public void saveAccount(BankAccount account, Path path) {
        Path file = path.resolve(account.getAccountNumber() + ".dat");
        try (DataOutputStream outputStream = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(file)))){
            outputStream.writeUTF(account.getAccountNumber());
            outputStream.writeUTF(account.getOwner());
            outputStream.writeDouble(account.getBalance());
        } catch (IOException e) {
            throw new IllegalStateException("Cannot write file");
        }
    }


    public BankAccount loadAccount(InputStream inputStream) {
        BankAccount bankAccount;
        try (DataInputStream input = new DataInputStream(new BufferedInputStream(inputStream))){
            String accountNumber = input.readUTF();
            String name = input.readUTF();
            double balace = input.readDouble();
            bankAccount = new BankAccount(accountNumber, name, balace);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
        return bankAccount;
    }

    public static void main(String[] args) {
        BankAccountManager bm = new BankAccountManager();

        bm.saveAccount(new BankAccount("10092395-77541845-00000000", "John Doe", 123456.6), Path.of("temp/account"));

    }
}
