package laurel.beth.thomson.followkstate;

/**
 * Created by laurel on 3/15/18.
 */

public class User implements Comparable<User> {
    private String mHandle;
    private String mName;

    public User (String handle, String name)
    {
        mName = name;
        mHandle = handle;
    }


    public String getHandle() {
        return mHandle;
    }

    public String getName() { return mName; }

    @Override
    public int compareTo(User user) {
        return this.mName.compareTo(user.mName);
    }
}
