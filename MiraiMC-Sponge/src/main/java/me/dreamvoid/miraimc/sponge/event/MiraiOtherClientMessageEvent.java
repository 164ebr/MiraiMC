package me.dreamvoid.miraimc.sponge.event;

import net.mamoe.mirai.event.events.OtherClientMessageEvent;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.impl.AbstractEvent;

/**
 * 被动收到消息 - 其他客户端消息
 */
public final class MiraiOtherClientMessageEvent extends AbstractEvent {
    private final Cause cause;

    public MiraiOtherClientMessageEvent(OtherClientMessageEvent event, Cause cause) {
        this.event = event;
        this.cause = cause;
    }

    private final OtherClientMessageEvent event;

    /**
     * 返回接收到这条信息的机器人ID
     * @return 机器人ID
     */
    public long getBotID(){
        return event.getBot().getId();
    }

    /**
     * 返回发送这条信息的发送者名称
     * @return 发送者名称
     */
    public String getSenderNick(){
        return event.getSenderName();
    }

    /**
     * 返回接收到的消息内容
     * @return 消息内容
     */
    public String getMessage(){
        return event.getMessage().serializeToMiraiCode();
    }

    /**
     * 返回接收到这条信息的时间
     * @return 发送时间
     */
    public int getTime(){ return event.getTime(); }

    /**
     * (?)获取发送设备的种类
     * @return 客户端种类
     */
    public String getDeviceKind(){
        return event.getClient().getInfo().getDeviceKind();
    }

    /**
     * (?)获取发送设备的名称
     * @return 设备名称
     */
    public String getDeviceName(){
        return event.getClient().getInfo().getDeviceName();
    }

    /**
     * 获取原始事件内容<br>
     * [!] 不推荐使用
     * @return 原始事件内容
     */
    public String eventToString() {
        return event.toString();
    }

    @Override
    public @NotNull Cause getCause() {
        return cause;
    }
}