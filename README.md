# PUBLISH-SUBSCRIBE (PUB-SUB) DESIGN PATTERN

## 1) Publish-Subscribe (Pub-Sub) design pattern
There are three components in Pub-Sub pattern: Publisher, Subscriber and PubSub Service.
    
    1. Message Publisher: sends messages to the PubSub Service without any knowledge of message subscribers.
    2. Message Subscribers will only get the messages for which topics they are registered with the PubSubService.
    3. Publishers tag each message with a topic, and send it to the PubSubService which acts like a middleman between Publishers and receivers.
    4. Subscriber registers itself with PubSubService (middleman) and tells that it’s interested in messages related to a particular topic.
    5. Publisher-Subscriber pattern is highly loosely coupled architecture where the publishers don’t know who the subscribers are and subscribers don’t know who the publishers of topic are.
## 2) Implementation details:
Project Directory Structure:

    pubsuPatern
               |__ .idea 
               |__ src
               |    |__ pubsub
               |    |       |__ publisher
               |    |       |         |__ Publisher.java
               |    |       |         |__ PublisherImpl.java
               |    |       |__ service
               |    |       |         |__ PubSubService.java 
               |    |       |__ subscriber
               |    |       |         |__ Subscriber.java
               |    |       |         |__ SubscriberImpl.java
               |    |       |__ DriverClass.java
               |    |       |__ Message.java
               |    |__ pubsubPatern.iml
               |    |__ README.md 
               |__ External Library
      
* Publisher.java: interface defines the abstract method publish() which sends message to PubSub Service.

* PublisherImpl.java: class implements Publisher interface and implements publish method, which sends the message to PubSubService.

* Subscriber.java is an abstract class.

    - addSubscriber() – Adds/Registers subscriber for a topic with PubSub service.
    - unSubscribe() – Removes/Unsubscribes the subscriber for a topic with PubSub
    - List<Message> subscriberMessages – List of message which stores the messages received by Subscriber.
    - getMessagesForSubscriberOfTopic() – Method which requests for messages for subscriber of topic.

* SubscriberImpl.java: class extends Subscriber and implements the abstract methods.

* Message.java: class is a simple POJO class to represent the messages. It has topic attribute (for this subscriber is interested) and an attribute for message payload.

* PubSubService.java

    - Map<String, Set<Subscriber>> subscribersTopicMap – Stores the subscribers interested in a topic.
    - Queue<Message> messageQueue – Stores the messages published by publishers.
    - addMessageToQueue() – Adds message published by publishers to message queue.
    - addSubscriber () – Adds a subscriber for a topic.
    - removeSubscriber() – removes a subscriber for a topic.
    - broadcast() – Broadcast new messages added in queue to all subscribers of the topic. The messagesQueue will be empty after broadcasting is complete.
    - getMessagesForSubscriberOfTopic() – Sends messages about a topic for subscriber at any point.

## 3) Output

    Messages of dogSubscriber are: 
    Message Topic -> dog : gau gau 
    Message Topic -> dog : ang ang
    Message Topic -> dog : gau gau ang ang
    
    Messages of catSubscriber are: 
    Message Topic -> cat : meo meo
    Message Topic -> cat : ngao  ngao
    
    Messages of All message Subscriber are: 
    Message Topic -> dog : gau gau 
    Message Topic -> dog : ang ang
    Message Topic -> dog : gau gau ang ang
    Message Topic -> cat : meo meo
    Message Topic -> cat : ngao  ngao
    
    Publishing 2 more Messages...
    
    Messages of dog Subscriber now are: 
    Message Topic -> dog : gau gau 
    Message Topic -> dog : ang ang
    Message Topic -> dog : gau gau ang ang
    Message Topic -> dog : i'm dog , so: gau gau
    Message Topic -> dog : i hate cat
    
    Process finished with exit code 0


