package ch.abbts.swt.swayingcitadell.amqp;

import ch.abbts.swt.amqp.AmqpController;
import ch.abbts.swt.amqp.MessageComposer;
import com.rabbitmq.client.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeoutException;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = {
    AmqpController.class
})
public class AmqpControllerE2ETest {

  @Autowired
  private WebTestClient webClient;

  @InjectMocks
  private AmqpController controllerUT = new AmqpController(new MockChannel());

  @Before
  public void setUp(){
    controllerUT.setMessageSpawn(new MessageComposer() {
      @Override
      public String compose() {
        return "{\"name\":\"TESTCOMPOSER\", \"message\": \"ABCABCABC\"}";
      }
    });
  }

  @Test
  public void testPublish() throws Exception {
    WebTestClient.bindToController(controllerUT)
        .build()
        .get()
        .uri("/mq/publish")
        .accept(MediaType.TEXT_HTML)
        .exchange()
        .expectStatus()
        .isOk()
        .expectBody()
        .json("{\"name\":\"TESTCOMPOSER\", \"message\": \"ABCABCABC\"}");
  }
}

class MockChannel implements Channel {

  @Override
  public int getChannelNumber() {
    return 0;
  }

  @Override
  public Connection getConnection() {
    return null;
  }

  @Override
  public void close() throws IOException, TimeoutException {

  }

  @Override
  public void close(int i, String s) throws IOException, TimeoutException {

  }

  @Override
  public void abort() throws IOException {

  }

  @Override
  public void abort(int i, String s) throws IOException {

  }

  @Override
  public void addReturnListener(ReturnListener returnListener) {

  }

  @Override
  public ReturnListener addReturnListener(ReturnCallback returnCallback) {
    return null;
  }

  @Override
  public boolean removeReturnListener(ReturnListener returnListener) {
    return false;
  }

  @Override
  public void clearReturnListeners() {

  }

  @Override
  public void addConfirmListener(ConfirmListener confirmListener) {

  }

  @Override
  public ConfirmListener addConfirmListener(ConfirmCallback confirmCallback, ConfirmCallback confirmCallback1) {
    return null;
  }

  @Override
  public boolean removeConfirmListener(ConfirmListener confirmListener) {
    return false;
  }

  @Override
  public void clearConfirmListeners() {

  }

  @Override
  public Consumer getDefaultConsumer() {
    return null;
  }

  @Override
  public void setDefaultConsumer(Consumer consumer) {

  }

  @Override
  public void basicQos(int i, int i1, boolean b) throws IOException {

  }

  @Override
  public void basicQos(int i, boolean b) throws IOException {

  }

  @Override
  public void basicQos(int i) throws IOException {

  }

  @Override
  public void basicPublish(String s, String s1, AMQP.BasicProperties basicProperties, byte[] bytes) throws IOException {

  }

  @Override
  public void basicPublish(String s, String s1, boolean b, AMQP.BasicProperties basicProperties, byte[] bytes) throws IOException {

  }

  @Override
  public void basicPublish(String s, String s1, boolean b, boolean b1, AMQP.BasicProperties basicProperties, byte[] bytes) throws IOException {

  }

  @Override
  public AMQP.Exchange.DeclareOk exchangeDeclare(String s, String s1) throws IOException {
    return null;
  }

  @Override
  public AMQP.Exchange.DeclareOk exchangeDeclare(String s, BuiltinExchangeType builtinExchangeType) throws IOException {
    return null;
  }

  @Override
  public AMQP.Exchange.DeclareOk exchangeDeclare(String s, String s1, boolean b) throws IOException {
    return null;
  }

  @Override
  public AMQP.Exchange.DeclareOk exchangeDeclare(String s, BuiltinExchangeType builtinExchangeType, boolean b) throws IOException {
    return null;
  }

  @Override
  public AMQP.Exchange.DeclareOk exchangeDeclare(String s, String s1, boolean b, boolean b1, Map<String, Object> map) throws IOException {
    return null;
  }

  @Override
  public AMQP.Exchange.DeclareOk exchangeDeclare(String s, BuiltinExchangeType builtinExchangeType, boolean b, boolean b1, Map<String, Object> map) throws IOException {
    return null;
  }

  @Override
  public AMQP.Exchange.DeclareOk exchangeDeclare(String s, String s1, boolean b, boolean b1, boolean b2, Map<String, Object> map) throws IOException {
    return null;
  }

  @Override
  public AMQP.Exchange.DeclareOk exchangeDeclare(String s, BuiltinExchangeType builtinExchangeType, boolean b, boolean b1, boolean b2, Map<String, Object> map) throws IOException {
    return null;
  }

  @Override
  public void exchangeDeclareNoWait(String s, String s1, boolean b, boolean b1, boolean b2, Map<String, Object> map) throws IOException {

  }

  @Override
  public void exchangeDeclareNoWait(String s, BuiltinExchangeType builtinExchangeType, boolean b, boolean b1, boolean b2, Map<String, Object> map) throws IOException {

  }

  @Override
  public AMQP.Exchange.DeclareOk exchangeDeclarePassive(String s) throws IOException {
    return null;
  }

  @Override
  public AMQP.Exchange.DeleteOk exchangeDelete(String s, boolean b) throws IOException {
    return null;
  }

  @Override
  public void exchangeDeleteNoWait(String s, boolean b) throws IOException {

  }

  @Override
  public AMQP.Exchange.DeleteOk exchangeDelete(String s) throws IOException {
    return null;
  }

  @Override
  public AMQP.Exchange.BindOk exchangeBind(String s, String s1, String s2) throws IOException {
    return null;
  }

  @Override
  public AMQP.Exchange.BindOk exchangeBind(String s, String s1, String s2, Map<String, Object> map) throws IOException {
    return null;
  }

  @Override
  public void exchangeBindNoWait(String s, String s1, String s2, Map<String, Object> map) throws IOException {

  }

  @Override
  public AMQP.Exchange.UnbindOk exchangeUnbind(String s, String s1, String s2) throws IOException {
    return null;
  }

  @Override
  public AMQP.Exchange.UnbindOk exchangeUnbind(String s, String s1, String s2, Map<String, Object> map) throws IOException {
    return null;
  }

  @Override
  public void exchangeUnbindNoWait(String s, String s1, String s2, Map<String, Object> map) throws IOException {

  }

  @Override
  public AMQP.Queue.DeclareOk queueDeclare() throws IOException {
    return null;
  }

  @Override
  public AMQP.Queue.DeclareOk queueDeclare(String s, boolean b, boolean b1, boolean b2, Map<String, Object> map) throws IOException {
    return null;
  }

  @Override
  public void queueDeclareNoWait(String s, boolean b, boolean b1, boolean b2, Map<String, Object> map) throws IOException {

  }

  @Override
  public AMQP.Queue.DeclareOk queueDeclarePassive(String s) throws IOException {
    return null;
  }

  @Override
  public AMQP.Queue.DeleteOk queueDelete(String s) throws IOException {
    return null;
  }

  @Override
  public AMQP.Queue.DeleteOk queueDelete(String s, boolean b, boolean b1) throws IOException {
    return null;
  }

  @Override
  public void queueDeleteNoWait(String s, boolean b, boolean b1) throws IOException {

  }

  @Override
  public AMQP.Queue.BindOk queueBind(String s, String s1, String s2) throws IOException {
    return null;
  }

  @Override
  public AMQP.Queue.BindOk queueBind(String s, String s1, String s2, Map<String, Object> map) throws IOException {
    return null;
  }

  @Override
  public void queueBindNoWait(String s, String s1, String s2, Map<String, Object> map) throws IOException {

  }

  @Override
  public AMQP.Queue.UnbindOk queueUnbind(String s, String s1, String s2) throws IOException {
    return null;
  }

  @Override
  public AMQP.Queue.UnbindOk queueUnbind(String s, String s1, String s2, Map<String, Object> map) throws IOException {
    return null;
  }

  @Override
  public AMQP.Queue.PurgeOk queuePurge(String s) throws IOException {
    return null;
  }

  @Override
  public GetResponse basicGet(String s, boolean b) throws IOException {
    return null;
  }

  @Override
  public void basicAck(long l, boolean b) throws IOException {

  }

  @Override
  public void basicNack(long l, boolean b, boolean b1) throws IOException {

  }

  @Override
  public void basicReject(long l, boolean b) throws IOException {

  }

  @Override
  public String basicConsume(String s, Consumer consumer) throws IOException {
    return null;
  }

  @Override
  public String basicConsume(String s, DeliverCallback deliverCallback, CancelCallback cancelCallback) throws IOException {
    return null;
  }

  @Override
  public String basicConsume(String s, DeliverCallback deliverCallback, ConsumerShutdownSignalCallback consumerShutdownSignalCallback) throws IOException {
    return null;
  }

  @Override
  public String basicConsume(String s, DeliverCallback deliverCallback, CancelCallback cancelCallback, ConsumerShutdownSignalCallback consumerShutdownSignalCallback) throws IOException {
    return null;
  }

  @Override
  public String basicConsume(String s, boolean b, Consumer consumer) throws IOException {
    return null;
  }

  @Override
  public String basicConsume(String s, boolean b, DeliverCallback deliverCallback, CancelCallback cancelCallback) throws IOException {
    return null;
  }

  @Override
  public String basicConsume(String s, boolean b, DeliverCallback deliverCallback, ConsumerShutdownSignalCallback consumerShutdownSignalCallback) throws IOException {
    return null;
  }

  @Override
  public String basicConsume(String s, boolean b, DeliverCallback deliverCallback, CancelCallback cancelCallback, ConsumerShutdownSignalCallback consumerShutdownSignalCallback) throws IOException {
    return null;
  }

  @Override
  public String basicConsume(String s, boolean b, Map<String, Object> map, Consumer consumer) throws IOException {
    return null;
  }

  @Override
  public String basicConsume(String s, boolean b, Map<String, Object> map, DeliverCallback deliverCallback, CancelCallback cancelCallback) throws IOException {
    return null;
  }

  @Override
  public String basicConsume(String s, boolean b, Map<String, Object> map, DeliverCallback deliverCallback, ConsumerShutdownSignalCallback consumerShutdownSignalCallback) throws IOException {
    return null;
  }

  @Override
  public String basicConsume(String s, boolean b, Map<String, Object> map, DeliverCallback deliverCallback, CancelCallback cancelCallback, ConsumerShutdownSignalCallback consumerShutdownSignalCallback) throws IOException {
    return null;
  }

  @Override
  public String basicConsume(String s, boolean b, String s1, Consumer consumer) throws IOException {
    return null;
  }

  @Override
  public String basicConsume(String s, boolean b, String s1, DeliverCallback deliverCallback, CancelCallback cancelCallback) throws IOException {
    return null;
  }

  @Override
  public String basicConsume(String s, boolean b, String s1, DeliverCallback deliverCallback, ConsumerShutdownSignalCallback consumerShutdownSignalCallback) throws IOException {
    return null;
  }

  @Override
  public String basicConsume(String s, boolean b, String s1, DeliverCallback deliverCallback, CancelCallback cancelCallback, ConsumerShutdownSignalCallback consumerShutdownSignalCallback) throws IOException {
    return null;
  }

  @Override
  public String basicConsume(String s, boolean b, String s1, boolean b1, boolean b2, Map<String, Object> map, Consumer consumer) throws IOException {
    return null;
  }

  @Override
  public String basicConsume(String s, boolean b, String s1, boolean b1, boolean b2, Map<String, Object> map, DeliverCallback deliverCallback, CancelCallback cancelCallback) throws IOException {
    return null;
  }

  @Override
  public String basicConsume(String s, boolean b, String s1, boolean b1, boolean b2, Map<String, Object> map, DeliverCallback deliverCallback, ConsumerShutdownSignalCallback consumerShutdownSignalCallback) throws IOException {
    return null;
  }

  @Override
  public String basicConsume(String s, boolean b, String s1, boolean b1, boolean b2, Map<String, Object> map, DeliverCallback deliverCallback, CancelCallback cancelCallback, ConsumerShutdownSignalCallback consumerShutdownSignalCallback) throws IOException {
    return null;
  }

  @Override
  public void basicCancel(String s) throws IOException {

  }

  @Override
  public AMQP.Basic.RecoverOk basicRecover() throws IOException {
    return null;
  }

  @Override
  public AMQP.Basic.RecoverOk basicRecover(boolean b) throws IOException {
    return null;
  }

  @Override
  public AMQP.Tx.SelectOk txSelect() throws IOException {
    return null;
  }

  @Override
  public AMQP.Tx.CommitOk txCommit() throws IOException {
    return null;
  }

  @Override
  public AMQP.Tx.RollbackOk txRollback() throws IOException {
    return null;
  }

  @Override
  public AMQP.Confirm.SelectOk confirmSelect() throws IOException {
    return null;
  }

  @Override
  public long getNextPublishSeqNo() {
    return 0;
  }

  @Override
  public boolean waitForConfirms() throws InterruptedException {
    return false;
  }

  @Override
  public boolean waitForConfirms(long l) throws InterruptedException, TimeoutException {
    return false;
  }

  @Override
  public void waitForConfirmsOrDie() throws IOException, InterruptedException {

  }

  @Override
  public void waitForConfirmsOrDie(long l) throws IOException, InterruptedException, TimeoutException {

  }

  @Override
  public void asyncRpc(Method method) throws IOException {

  }

  @Override
  public Command rpc(Method method) throws IOException {
    return null;
  }

  @Override
  public long messageCount(String s) throws IOException {
    return 0;
  }

  @Override
  public long consumerCount(String s) throws IOException {
    return 0;
  }

  @Override
  public CompletableFuture<Command> asyncCompletableRpc(Method method) throws IOException {
    return null;
  }

  @Override
  public void addShutdownListener(ShutdownListener shutdownListener) {

  }

  @Override
  public void removeShutdownListener(ShutdownListener shutdownListener) {

  }

  @Override
  public ShutdownSignalException getCloseReason() {
    return null;
  }

  @Override
  public void notifyListeners() {

  }

  @Override
  public boolean isOpen() {
    return false;
  }
}