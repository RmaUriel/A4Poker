/*
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
public class MQTTConnection {
    private final String BROKER = "tcp://broker.hivemq.com:1883";
    private final String TOPIC = "CSC-307-POKER-CONNECTION";
    public final String CLIENT_ID;
    public MqttClient client;

    public MQTTConnection(String clientID){
        this.CLIENT_ID = clientID;
        try {
            client = new MqttClient(BROKER, clientID);
            client.connect();

            System.out.println("Connected to BROKER: " + BROKER);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}

 */
