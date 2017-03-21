package io.digdag.guice.rs.server.undertow;

import com.google.common.base.Optional;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLContext;
import org.immutables.value.Value;

public interface UndertowServerConfig
{
    @Value.Immutable
    @Value.Style(typeImmutable = "Undertow*")
    interface ListenAddress
    {
        /**
         * Local port to listen on.
         */
        int getPort();

        /**
         * Local address to listen on.
         */
        String getBind();

        /**
         * Enable SSL.
         */
        Optional<SSLContext> getSslContext();

        /**
         * Name of this local address used as a key of GuiceRsServerControl.getLocalAddresses.
         */
        String getName();
    }

    /**
     * List of listen addresses.
     */
    List<ListenAddress> getListenAddresses();

    /**
     * Access log path. Null to disable logging.
     */
    Optional<String> getAccessLogPath();

    /**
     * Access log format. Default is 'json' that uses json format
     * with the labeling recommended in http://ltsv.org/.
     */
    String getAccessLogPattern();

    /**
     * Number of HTTP IO threads.
     */
    Optional<Integer> getHttpIoThreads();

    /**
     * Number of HTTP request processing threads.
     */
    Optional<Integer> getHttpWorkerThreads();

    /**
     * Maximum allowed time for clients to keep a connection open without sending
     * requests or receiving responses in seconds.
     */
    Optional<Integer> getHttpNoRequestTimeout();

    /**
     * Maximum allowed time of reading a HTTP request in seconds.
     *
     * This doesn't affect on reading request body.
     */
    Optional<Integer> getHttpRequestParseTimeout();

    /**
     * Maximum allowed idle time of reading HTTP request and writing HTTP response
     * in seconds.
     */
    Optional<Integer> getHttpIoIdleTimeout();

    /**
     * JMX port. Null to disable JMX.
     */
    Optional<Integer> getJmxPort();

    /**
     * Enable HTTP/2.
     */
    boolean getEnableHttp2();
}
