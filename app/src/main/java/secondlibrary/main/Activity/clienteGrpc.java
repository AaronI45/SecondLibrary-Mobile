package secondlibrary.main.Activity;

import android.util.Log;

public class clienteGrpc {
        private static final String PORT = "localhost:8081";

        public static void enviarMensaje(String mensaje){
            try {
                // Create a channel to the server
                ManagedChannel channel = ManagedChannelBuilder.forAddress(PORT, InsecureChannelCredentials.create()).build();

                // Create a stub for the service
                ChatServiceGrpc.ChatServiceBlockingStub stub = ChatServiceGrpc.newBlockingStub(channel);

                // Send the message
                Message messageProto = Message.newBuilder().setMessage(mensaje).build();
                stub.enviarMensaje(messageProto);

                // Close the channel
                channel.shutdownNow();
            } catch (Exception e){
                Log.e("Cliente grpc", "Error enviando el mensaje", e);
            }
        }
}
