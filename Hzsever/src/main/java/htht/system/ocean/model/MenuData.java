package htht.system.ocean.model;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Table(name = "MENU_DATA")
public class MenuData {
    @Id
    @Column(name = "MENU_ID")
    private Long menuId;

    @Column(name = "MENU_NAME")
    private String menuName;
    @Transient
    private Boolean chooseBol =false;
    /**
     * @return MENU_ID
     */
    public Long getMenuId() {
        return menuId;
    }

    public Boolean getChooseBol() {
        return chooseBol;
    }

    public void setChooseBol(Boolean chooseBol) {
        this.chooseBol = chooseBol;
    }

    /**
     * @param menuId
     */

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    /**
     * @return MENU_NAME
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * @param menuName
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
}