package generic;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RoleStoreTest {

    @Test
    public void whenAddAndFindDirectorRole() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Director"));
        Role result = roleStore.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Director");
    }

    @Test
    public void whenAddDirectorRoleAndFindNull() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Director"));
        Role result = roleStore.findById("2");
        assertThat(result).isNull();
    }

    @Test
    public void whenAddTwoDuplicatesIdAndFindRoleIsAdmin() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Admin"));
        roleStore.add(new Role("1", "Director"));
        Role result = roleStore.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Admin");
    }

    @Test
    public void whenReplaceAndFindThenRoleNameIsDirector() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Player"));
        roleStore.replace("1", new Role("1", "Director"));
        Role result = roleStore.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Director");
    }

    @Test
    public void whenReplaceAndAndFindThenNoRoleNameChanging() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Player"));
        roleStore.replace("1", new Role("1", "Player"));
        Role result = roleStore.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Player");
    }

    @Test
    public void whenDeleteAndThenRoleNameIsNull() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Player"));
        roleStore.delete("1");
        Role result = roleStore.findById("1");
        assertThat(result).isNull();
    }

    @Test
    public void whenDeleteThenRoleNameIsModerator() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Moderator"));
        roleStore.delete("2");
        Role result = roleStore.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Moderator");
    }

    @Test
    public void whenFindAndThenRoleNameIsAdmin() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Admin"));
        Role result = roleStore.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Admin");
    }

    @Test
    public void whenFindAndThenRoleNameIsNull() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Admin"));
        Role result = roleStore.findById("2");
        assertThat(result).isNull();
    }

    @Test
    public void whenReplaceAndTrue() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Player"));
        Boolean result = roleStore.replace("1", new Role("1", "Director"));
        assertThat(result).isTrue();
    }

    @Test
    public void whenReplaceAndFalse() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Player"));
        Boolean result = roleStore.replace("2", new Role("1", "Player"));
        assertThat(result).isFalse();
    }

    @Test
    public void whenDeleteAndTrue() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Player"));
        Boolean result = roleStore.delete("1");
        assertThat(result).isTrue();
    }

    @Test
    public void whenDeleteAndFalse() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Moderator"));
        Boolean result = roleStore.delete("2");
        assertThat(result).isFalse();
    }
}