package com.story.web.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 控制按钮权限
 *
 * @author : zoutuo
 * @version : 1.0
 * @date : 2016/2/26 14:41
 */
public class PrivilegeUtils {
//    //错误日志
//    private static final Logger logger = LoggerFactory.getLogger(PrivilegeUtils.class);
//
//    private static RedisUtil redisUtil;
//
//    private static ResourceDao resourceDao;
//
//    /**
//     * 检测用户是否有传来的权限
//     *
//     * @param resourceCode
//     * @return
//     */
//    public static boolean checkUserPrivilege(String resourceCode) {
//        if (resourceCode == null) {
//            return false;
//        }
//        List<Res> cacheFunction = getResources();//权限菜单字符串
//        if (cacheFunction == null || cacheFunction.size() == 0) {
//            return false;
//        }
//
//        return contains(cacheFunction, resourceCode);
//    }
//
//    /**
//     * 检测用户是否有传来的权限（多权限验证）
//     * 用法：
//     * #if($!privilegeUtils.checkUserPrivilegeBatch("msbookadd", "msbookedit")) #end
//     *
//     * @param resourceCodes
//     * @return
//     */
//    public static boolean checkUserPrivilegeBatch(String... resourceCodes) {
//        if (resourceCodes == null) {
//            return false;
//        }
//        List<Res> cacheFunction = getResources();//权限菜单字符串
//        if (cacheFunction == null) {
//            return false;
//        }
//
//        for (String resourceCode : resourceCodes) {
//            if (!contains(cacheFunction, resourceCode)) {
//                return false;
//            }
//        }
//
//        return true;
//    }
//
//    /**
//     * 检测用户是否有传来的权限（多权限验证，其中有一个拥有权限即返回true）
//     * 用法：
//     * #if($!privilegeUtils.checkUserPrivilegeAny("msbookadd", "msbookedit")) #end
//     *
//     * @param resourceCodes
//     * @return
//     */
//    public static boolean checkUserPrivilegeAny(String... resourceCodes) {
//        if (resourceCodes == null) {
//            return false;
//        }
//        List<Res> cacheFunction = getResources();//权限菜单字符串
//        if (cacheFunction == null) {
//            return false;
//        }
//
//        for (String resourceCode : resourceCodes) {
//            if (contains(cacheFunction, resourceCode)) {
//                return true;
//            }
//        }
//
//        return false;
//    }
//
//    /**
//     * 验证是否可当天取消预约权限
//     * <p/>
//     * 用法：与checkUserPrivilege同时使用：
//     * #if($!privilegeUtils.checkUserPrivilege("msbookadd") && $!privilegeUtils.checkUserPriCancelSameDay("date", "resourceCode"))
//     * XXXXX
//     * #end
//     *
//     * @param date
//     * @param resourceCode
//     * @return
//     */
//    public static boolean checkUserPriCancelSameDay(String date, String resourceCode) {
//        if (resourceCode == null) {
//            return false;
//        }
//        List<Res> cacheFunction = getResources();//权限菜单字符串
//        if (cacheFunction == null) {
//            return false;
//        }
//
//        String today = DateUtil.toStandardDate(new Date());//今天
//
//        return !today.equals(date) || contains(cacheFunction, resourceCode);
//    }
//
//    /**
//     * 验证除自己外是否有其他权限
//     * <p/>
//     * 用法：与checkUserPrivilege同时使用：
//     * #if($!privilegeUtils.checkUserPrivilege("msbookadd") && $!privilegeUtils.checkUserPriCancelOther("self", "resourceCode"))
//     * XXXXX
//     * #end
//     *
//     * @param self         是否是自己 ：1、自己；0、不是自己
//     * @param resourceCode 是否允许操作别人的预约单（传【MSBOOK-CANCEL-OTHER】代表允许操作别人的单子）
//     * @return
//     */
//    public static boolean checkUserPrivilegeOther(Integer self, String resourceCode) {
//        if (resourceCode == null) {
//            return false;
//        }
//        List<Res> cacheFunction = getResources();//权限菜单字符串
//        if (cacheFunction == null) {
//            return false;
//        }
//
//        return self != 0 || contains(cacheFunction, resourceCode);
//    }
//
//    private static boolean contains(List<Res> resList, String resource){
//        for(Res res : resList){
//            if(resource.equals(res.getUrl())){
//                return true;
//            }
//        }
//
//        return false;
//    }
//
//    /**
//     * 拼装字符串，返回最终的资源码
//     *
//     * @param resourceCode
//     * @return
//     */
////    private static String getResourceCode(String resourceCode) {
////        return new StringBuffer().append("\"").append(resourceCode).append("\"").toString();
////    }
//
//    /**
//     * 获取权限字符串
//     *
//     * @return
//     */
//    private static List<Res> getResources() {
//        String roleID = LoginContextUtil.getLoginContext().getRoleID();
//        return resourceDao.queryMenuListByRoleID(roleID);
//    }
//
//    @Resource(name = "redisUtil")
//    public void setRedisUtil(RedisUtil redisUtil) {
//        PrivilegeUtils.redisUtil = redisUtil;
//    }
//
//    @Resource
//    public void setResourceDao(ResourceDao resourceDao) {
//        PrivilegeUtils.resourceDao = resourceDao;
//    }

}
