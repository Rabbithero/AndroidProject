package demo.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import demo.twoproject.R;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> arrayList_groupData;
    ArrayList<ArrayList<String>> arrayList_memberData;
    ExAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ExpandableListView expandableListView= (ExpandableListView) findViewById(R.id.expandableListView);
        arrayList_groupData = new ArrayList<String>();
        arrayList_memberData = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < 5; i++)
        {
            arrayList_groupData.add("Group "+i);
            ArrayList<String> arrayList_memberDataItem = new ArrayList<String>();
            for (int j = 0; j < 6; j++)
            {
                arrayList_memberDataItem.add("member "+j);
            }
            arrayList_memberData.add(arrayList_memberDataItem);
        }
        adapter=new ExAdapter(this);
        expandableListView.setAdapter(adapter);
        expandableListView.setGroupIndicator(null);//除去自带的箭头，自带的箭头在父列表的最左边，不展开向下，展开向上
        expandableListView.setDivider(null);//这个是设定每个Group之间的分割线。,默认有分割线，设置null没有分割线

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View view, int groupPosition,
                                        int childPosition, long id) {
                // TODO Auto-generated method stub
                adapter.setChildSelection(groupPosition,childPosition);
                adapter.notifyDataSetChanged();
                return true;
            }
        });

}
    public class ExAdapter extends BaseExpandableListAdapter
    {
        Context context;
        int selectParentItem = -1;
        int selectChildItem = -1;

        public ExAdapter(Context context) {
            // TODO Auto-generated constructor stub
            this.context = context;
        }

        public void setChildSelection(int groupPosition, int childPosition)
        {
            selectParentItem = groupPosition;
            selectChildItem = childPosition;
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            // TODO Auto-generated method stub
            return arrayList_memberData.get(groupPosition).get(childPosition);
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            // TODO Auto-generated method stub
            return childPosition;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView,
                                 ViewGroup parent) {
            // TODO Auto-generated method stub
            View view = convertView;
            Log.i("++++++++++", "groupPosition="+groupPosition+","+"childPosition"+childPosition);
            if (null == view)
            {
                //获取LayoutInflater
                LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                //获取对应的布局
                view = layoutInflater.inflate(R.layout.memberlayout, null);
            }
            TextView textView = (TextView)view.findViewById(R.id.memberlayout_textView);
            textView.setText(arrayList_memberData.get(groupPosition).get(childPosition));
            if (selectChildItem == childPosition && selectParentItem == groupPosition)
            {
                Log.i("++++++++++", "点击："+groupPosition+","+childPosition);
            }

            return view;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {

            return true;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            // TODO Auto-generated method stub
            return arrayList_memberData.get(groupPosition).size();
        }

        @Override
        public Object getGroup(int groupPosition) {
            // TODO Auto-generated method stub
            return arrayList_groupData.get(groupPosition);
        }

        @Override
        public int getGroupCount() {
            // TODO Auto-generated method stub
            return arrayList_groupData.size();
        }

        @Override
        public long getGroupId(int groupPosition) {
            // TODO Auto-generated method stub
            return groupPosition;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView,
                                 ViewGroup parent) {
            // TODO Auto-generated method stub
            View view = convertView;
            Log.i("++++++++++", "groupPosition="+groupPosition);
            if (null == view)
            {
                LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = layoutInflater.inflate(R.layout.grouplayout, null);
            }
            TextView textView = (TextView)view.findViewById(R.id.grouplayout_textView);
            textView.setText(arrayList_groupData.get(groupPosition));
            ImageView image=(ImageView) view.findViewById(R.id.grouplayout_imageView_tubiao);
            if(isExpanded)
            {
                image.setBackgroundResource(R.mipmap.list_down_arrow);
            }
            else
            {
                image.setBackgroundResource(R.mipmap.list_left_arrow);
            }
            return view;
        }

        @Override
        public boolean hasStableIds() {

            return true;
        }


    }
}
