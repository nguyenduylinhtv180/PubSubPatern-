package pubsub;

import pubsub.publisher.Publisher;
import pubsub.publisher.PublisherImpl;
import pubsub.service.PubSubService;
import pubsub.subscriber.Subscriber;
import pubsub.subscriber.SubscriberImpl;

public class DriverClass {
    public static void main(String[] args) {

        //Instantiate publishers, subscribers and PubSubService
        Publisher linh1Publisher = new PublisherImpl();
        Publisher linh2Publisher = new PublisherImpl();

        Subscriber javaSubscriber = new SubscriberImpl();
        Subscriber allLanguagesSubscriber = new SubscriberImpl();
        Subscriber pythonSubscriber = new SubscriberImpl();

        PubSubService pubSubService = new PubSubService();

        //Declare Messages and Publish Messages to PubSubService
        Message javaMsg1 = new Message("linhnd4", "im linh1");
        Message javaMsg2 = new Message("linhnd4", "i'm tiger");
        Message javaMsg3 = new Message("linhnd4", "i like it");

        linh1Publisher.publish(javaMsg1, pubSubService);
        linh1Publisher.publish(javaMsg2, pubSubService);
        linh1Publisher.publish(javaMsg3, pubSubService);

        Message pythonMsg1 = new Message("life", "hard and Powerful programming language");
        Message pythonMsg2 = new Message("life", "Advanced  message");

        linh2Publisher.publish(pythonMsg1, pubSubService);
        linh2Publisher.publish(pythonMsg2, pubSubService);

        //Declare Subscribers
        javaSubscriber.addSubscriber("linhnd4",pubSubService);		//Java subscriber only subscribes to Java topics
        pythonSubscriber.addSubscriber("life",pubSubService);   //Python subscriber only subscribes to Python topics
        allLanguagesSubscriber.addSubscriber("linhnd4", pubSubService);	//all subscriber, subscribes to both Java and Python
        allLanguagesSubscriber.addSubscriber("life", pubSubService);

        //Trying unSubscribing a subscriber
        //pythonSubscriber.unSubscribe("Python", pubSubService);

        //Broadcast message to all subscribers. After broadcast, messageQueue will be empty in PubSubService
        pubSubService.broadcast();

        //Print messages of each subscriber to see which messages they got
        System.out.println("Messages of linhnd4 Subscriber are: ");
        javaSubscriber.printMessages();

        System.out.println("\nMessages of life Subscriber are: ");
        pythonSubscriber.printMessages();

        System.out.println("\nMessages of All message Subscriber are: ");
        allLanguagesSubscriber.printMessages();

        //After broadcast the messagesQueue will be empty, so publishing new messages to server
        System.out.println("\nPublishing 2 more Messages...");
        Message javaMsg4 = new Message("linhnd4", "JSP and Servlets");
        Message javaMsg5 = new Message("linhnd4", "Struts framework");

        linh1Publisher.publish(javaMsg4, pubSubService);
        linh1Publisher.publish(javaMsg5, pubSubService);

        javaSubscriber.getMessagesForSubscriberOfTopic("linhnd4", pubSubService);
        System.out.println("\nMessages of linhnd4 Subscriber now are: ");
        javaSubscriber.printMessages();
    }
}