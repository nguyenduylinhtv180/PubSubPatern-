#PUBLISH-SUBSCRIBE (PUB-SUB) DESIGN PATTERN

##1) Publish-Subscribe (Pub-Sub) design pattern
There are three components in Pub-Sub pattern: Publisher, Subscriber and PubSub Service.
    
    1. Message Publisher: sends messages to the PubSub Service without any knowledge of message subscribers.
    2. Message Subscribers will only get the messages for which topics they are registered with the PubSubService.
    3. Publishers tag each message with a topic, and send it to the PubSubService which acts like a middleman between Publishers and receivers.
    4. Subscriber registers itself with PubSubService (middleman) and tells that it’s interested in messages related to a particular topic.
    5. Publisher-Subscriber pattern is highly loosely coupled architecture where the publishers don’t know who the subscribers are and subscribers don’t know who the publishers of topic are.
##2) Implementation details:
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

* SubscriberImpl.java: class extends Subscriber and implements the abstract methods.

* Message.java: class is a simple POJO class to represent the messages. It has topic attribute (for this subscriber is interested) and an attribute for message payload.

* PubSubService .

## 3) Output

    Messages of linhnd4 Subscriber are: 
    Message Topic -> linhnd4 : im linh1
    Message Topic -> linhnd4 : i'm tiger
    Message Topic -> linhnd4 : i like it
    
    Messages of life Subscriber are: 
    Message Topic -> life : hard and Powerful programming language
    Message Topic -> life : Advanced  message
    
    Messages of All message Subscriber are: 
    Message Topic -> linhnd4 : im linh1
    Message Topic -> linhnd4 : i'm tiger
    Message Topic -> linhnd4 : i like it
    Message Topic -> life : hard and Powerful programming language
    Message Topic -> life : Advanced  message
    
    Publishing 2 more Messages...
    
    Messages of linhnd4 Subscriber now are: 
    Message Topic -> linhnd4 : im linh1
    Message Topic -> linhnd4 : i'm tiger
    Message Topic -> linhnd4 : i like it
    Message Topic -> linhnd4 : JSP and Servlets
    Message Topic -> linhnd4 : Struts framework


