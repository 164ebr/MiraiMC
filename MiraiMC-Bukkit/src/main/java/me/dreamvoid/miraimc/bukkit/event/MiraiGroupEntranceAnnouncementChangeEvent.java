package me.dreamvoid.miraimc.bukkit.event;

import net.mamoe.mirai.event.events.GroupEntranceAnnouncementChangeEvent;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 群设置 - 入群公告改变
 */
public class MiraiGroupEntranceAnnouncementChangeEvent extends Event {
    public MiraiGroupEntranceAnnouncementChangeEvent(GroupEntranceAnnouncementChangeEvent event) {
        super(true);
        this.event = event;
    }

    private static final HandlerList handlers = new HandlerList();
    private final GroupEntranceAnnouncementChangeEvent event;

    public @NotNull HandlerList getHandlers() { return handlers; }
    public static HandlerList getHandlerList() { return handlers; }

    /**
     * 获取机器人账号
     * @return 机器人账号
     */
    public long getBotID() { return event.getBot().getId(); }

    /**
     * 获取群号
     * @return 群号
     */
    public long getGroupID() {
        return event.getGroupId();
    }

    /**
     * 获取操作管理员QQ号
     * @return QQ号
     */
    public long getOperatorID(){
        if(event.getOperator()!=null){
            return event.getOperator().getId();
        } else return 0L;
    }

    /**
     * 获取更换前的群公告内容
     * @return 群公告内容
     */
    public String getOrigin(){
        return event.getOrigin();
    }

    /**
     * 获取更换后的群公告内容
     * @return 群公告内容
     */
    public String getNew(){
        return event.getNew();
    }

    /**
     * 获取哈希值
     * @return 哈希值
     */
    public int getHashCode(){
        return event.hashCode();
    }

    /**
     * 获取原始事件内容<br>
     * [!] 不推荐使用
     * @return 原始事件内容
     */
    public String eventToString() {
        return event.toString();
    }
}
