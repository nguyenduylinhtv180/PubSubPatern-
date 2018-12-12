package pubsub;

import pubsub.publisher.Publisher;
import pubsub.publisher.PublisherImpl;
import pubsub.service.PubSubService;
import pubsub.subscriber.Subscriber;
import pubsub.subscriber.SubscriberImpl;

public class DriverClass {
    public static void main(String[] args) {

        //Instantiate publishers, subscribers and PubSubService
        Publisher dogPublisher = new PublisherImpl();
        Publisher catPublisher = new PublisherImpl();

        Subscriber dogSubscriber = new SubscriberImpl();
        Subscriber animalSubscriber = new SubscriberImpl();
        Subscriber catSubscriber = new SubscriberImpl();

        PubSubService pubSubService = new PubSubService();

        //Declare Messages and Publish Messages to PubSubService
        Message dogMsg1 = new Message("dog", "gau gau ");
        Message dogMsg2 = new Message("dog", "ang ang");
        Message dogMsg3 = new Message("dog", "gau gau ang ang");

        dogPublisher.publish(dogMsg1, pubSubService);
        dogPublisher.publish(dogMsg2, pubSubService);
        dogPublisher.publish(dogMsg3, pubSubService);

        Message catMsg1 = new Message("cat", "meo meo");
        Message catMsg2 = new Message("cat", "ngao  ngao");

        catPublisher.publish(catMsg1, pubSubService);
        catPublisher.publish(catMsg2, pubSubService);

        //Declare Subscribers
        dogSubscriber.addSubscriber("dog",pubSubService);		//dog subscriber only subscribes to dog topics
        catSubscriber.addSubscriber("cat",pubSubService);   //cat subscriber only subscribes to cat topics
        animalSubscriber.addSubscriber("dog", pubSubService);	//all subscriber
        animalSubscriber.addSubscriber("cat", pubSubService);


        pubSubService.broadcast();

        //Print messages of each subscriber to see which messages they got
        System.out.println("Messages of dogSubscriber are: ");
        dogSubscriber.printMessages();

        System.out.println("\nMessages of catSubscriber are: ");
        catSubscriber.printMessages();

        System.out.println("\nMessages of All message Subscriber are: ");
        animalSubscriber.printMessages();

        //After broadcast the messagesQueue will be empty, so publishing new messages to server
        System.out.println("\nPublishing 2 more Messages...");
        Message dogMsg4 = new Message("dog", "i'm dog , so: gau gau");
        Message dogMsg5 = new Message("dog", "i hate cat");

        dogPublisher.publish(dogMsg4, pubSubService);
        dogPublisher.publish(dogMsg5, pubSubService);

        dogSubscriber.getMessagesForSubscriberOfTopic("dog", pubSubService);
        System.out.println("\nMessages of dog Subscriber now are: ");
        dogSubscriber.printMessages();
    }
}