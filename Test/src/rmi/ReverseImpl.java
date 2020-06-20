package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

class ReverseImpl implements Reverse {
    public String reverse(String str) throws RemoteException {
        return new StringBuffer(str).reverse().toString();
    }

    public static final String UNIQ_BINDING_NAME = "server.reverse";

    public static void main(String[] args) throws Exception {
        //создание объекта для удаленного доступа
        final ReverseImpl service = new ReverseImpl();
        //создание реестра расшареных объетов
        final Registry registry = LocateRegistry.createRegistry(2099);
        //создание "заглушки" – приемника удаленных вызовов
        Remote stub = UnicastRemoteObject.exportObject(service, 0);
        //регистрация "заглушки" в реeсте
        registry.bind(UNIQ_BINDING_NAME, stub);
        //усыпляем главный поток, иначе программа завершится
        Thread.sleep(Integer.MAX_VALUE);
    }
}